package org.zerock.domain;

import java.util.Date;

import lombok.Data;


/** λκΈ 1κ°μ VO*/
@Data
public class ReplyVO {

	private Long rno;
	private Long bno;
	
	private String reply;
	private String replyer;
	private Date replyDate;
	private Date updateDate;
}
