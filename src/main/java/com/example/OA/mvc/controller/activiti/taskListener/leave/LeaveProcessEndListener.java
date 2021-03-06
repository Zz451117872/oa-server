package com.example.OA.mvc.controller.activiti.taskListener.leave;

import com.example.OA.dao.activiti.LeaveMapper;
import com.example.OA.model.activiti.Leave;
import com.example.OA.mvc.common.Const;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 请假流程结束监听器，部署在工作流程中，流程“end”时调用（还有“start,take”等）
 *  ， 主要用于对业务对象的状态进行更新。
 *
 */
@Service
@Transactional
public class LeaveProcessEndListener implements ExecutionListener {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RepositoryService repositoryService;

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    LeaveMapper leaveMapper;


    @Override
    public void notify(DelegateExecution execution) throws Exception {
        //获取流程实例
        String processInstanceId = execution.getProcessInstanceId();
        ProcessInstance instance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();

        String businessKey  = instance.getBusinessKey();
        //获取业务对象
        Leave leave = leaveMapper.selectByPrimaryKey(Integer.parseInt(businessKey));
        //这个参数是以“expression”形式设置在连线的监听器上
       Object result = execution.getVariable("result");
      if("pass".equals(result))
      {
          leave.setStatus(Const.BusinessStatus.PASSED.getCode());
          logger.info("请假流程通过+++++++++++++++++++++++++++++++++");
      }else if("reject".equals(result))
      {
          leave.setStatus(Const.BusinessStatus.REJECTED.getCode());
          logger.info("请假流程被拒绝+++++++++++++++++++++++++++++++++");
      }else if("cancled".equals(result))
      {
          leave.setStatus(Const.BusinessStatus.CANCELED.getCode());
          logger.info("请假流程已取消+++++++++++++++++++++++++++++++++");
      }else {
          logger.info("请假流程异常+++++++++++++++++++++++++++++++++");
      }
        leaveMapper.updateByPrimaryKeySelective(leave);
    }
}
