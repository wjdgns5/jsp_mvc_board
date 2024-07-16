package com.tenco.tboard.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Board {
	
	private int id;
	private int userId;
	private String title;
	private String content;
	private Timestamp createdAt;

} // end of Board
