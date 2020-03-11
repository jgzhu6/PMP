package org.jeecg.modules.project.task.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;

/**
 * @Description: 分发详情表
 * @Author: jeecg-boot
 * @Date:   2020-03-04
 * @Version: V1.0
 */
@Data
@TableName("pmp_taskdetails")
public class PmpTaskdetails implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**主键*/
	@TableId(type = IdType.ID_WORKER_STR)
    private java.lang.String id;
	/**创建人*/
	@Excel(name = "创建人", width = 15)
    private java.lang.String create_by;
	/**创建日期*/
	@Excel(name = "创建日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date create_time;
	/**更新人*/
	@Excel(name = "更新人", width = 15)
    private java.lang.String update_by;
	/**更新日期*/
	@Excel(name = "更新日期", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date update_time;
	/**所属部门*/
	@Excel(name = "所属部门", width = 15)
    private java.lang.String sys_org_code;
	/**名称*/
	@Excel(name = "名称", width = 15)
    private java.lang.String taskname;
	/**任务内容*/
	@Excel(name = "任务内容", width = 15)
    private java.lang.String taskcontent;
	/**负责人*/
	@Excel(name = "负责人", width = 15)
    private java.lang.String taskprincipal;
	/**参与人*/
	@Excel(name = "参与人", width = 15)
    private java.lang.String participant;
	/**任务进度*/
	@Excel(name = "任务进度", width = 15)
    private java.lang.Integer taskschedule;
	/**任务状态*/
	@Excel(name = "任务状态", width = 15)
    private java.lang.Integer taskstatus;
	/**开始日期*/
	@Excel(name = "开始日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date startdate;
	/**结束日期*/
	@Excel(name = "结束日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date enddate;
	/**实际完成时间*/
	@Excel(name = "实际完成时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date completiontime;
	/**紧急程度*/
	@Excel(name = "紧急程度", width = 15)
    private java.lang.String emergencylevel;
	/**任务费用*/
	@Excel(name = "任务费用", width = 15)
    private java.lang.Double taskmoney;
	/**验收人*/
	@Excel(name = "验收人", width = 15)
    private java.lang.String receiver;
	/**验收人内容*/
	@Excel(name = "验收人内容", width = 15)
    private java.lang.String recContent;
	/**验收人打分*/
	@Excel(name = "验收人打分", width = 15)
    private java.lang.Integer recScore;
	/**任务备注*/
	@Excel(name = "任务备注", width = 15)
    private java.lang.String taskremark;
	/**附件*/
	@Excel(name = "附件", width = 15)
    private java.lang.String taskannex;
	/**是否删除*/
	@Excel(name = "是否删除", width = 15)
    private java.lang.Integer isdelete;
	/**父节点*/
	@Excel(name = "父节点", width = 36)
	private java.lang.String parent_id;
}
