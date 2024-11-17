package com.skyspacefourtyfour.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ScheduleDTO {

	private Integer scheduleId;

	private String dayOfWeek;

	private Date startTime;

	private Date endTime;






}
