package kr.co.goodee39.vo;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

public class DataVO1 {
	
	@AssertTrue
	private boolean data1;
	
	@AssertFalse
	private boolean data2;

	@Max(100)
	@Min(10)
	private int data3;
	
	@DecimalMax(value="100", inclusive = false)
	@DecimalMin(value="10", inclusive = false)
	private int data4;
	
	@Null
	private String data5;
	
	@NotNull
	private String data6;
	
	@Digits(integer = 3, fraction = 3)
	// 정수 값 3자리, 소수 값 3자리까지 제한
	private double data7;
	
	@Size(min = 3, max = 10)
	private String data8;
	
	@Pattern(regexp = "[a-zA-Z]*")
	private String data9;
	
	@NotEmpty
	// 아무것도 입력하지 않으면 오류를 발생시키나
	// 만약 스페이스를 통해 공백으로 으로 넘어가려한다면 넘어가짐
	private String data10;
	
	
	@NotBlank
	// 아무것도 입력하지 않으면 오류를 발생시키며
	// 공백으로 입력해도 넘어가지지 않음.
	private String data11;
	
	@Positive
	// 양수어야함
	// '0' 허용 하지 않음
	private int data12;
	
	@PositiveOrZero
	// 양수여야함
	// '0' 허용
	private int data13;
	
	@Negative
	// 음수어야함
	// '0' 허용 하지 않음
	private int data14;
	
	@NegativeOrZero
	// 음수여야함
	// '0' 허용
	private int data15;
	
	@Email
	@NotNull
	private String data16;
	
	public DataVO1() {
		this.data1 = true;
		this.data2 = false;
		this.data3 = 50;
		this.data4 = 50;
		this.data5 = null;
		this.data6 = "check";
		this.data7 = 111.111;
		this.data8 = "abcd";
		this.data9 = "abcd";
		this.data10 = "abcd";
		this.data11 = "abcd";
	}
	
	public boolean isData1() {
		return data1;
	}

	public void setData1(boolean data1) {
		this.data1 = data1;
	}

	public boolean isData2() {
		return data2;
	}

	public void setData2(boolean data2) {
		this.data2 = data2;
	}

	public int getData3() {
		return data3;
	}

	public void setData3(int data3) {
		this.data3 = data3;
	}

	public int getData4() {
		return data4;
	}

	public void setData4(int data4) {
		this.data4 = data4;
	}

	public String getData5() {
		return data5;
	}

	public void setData5(String data5) {
		this.data5 = data5;
	}

	public String getData6() {
		return data6;
	}

	public void setData6(String data6) {
		this.data6 = data6;
	}

	public double getData7() {
		return data7;
	}

	public void setData7(double data7) {
		this.data7 = data7;
	}

	public String getData8() {
		return data8;
	}

	public void setData8(String data8) {
		this.data8 = data8;
	}

	public String getData9() {
		return data9;
	}

	public void setData9(String data9) {
		this.data9 = data9;
	}

	public String getData10() {
		return data10;
	}

	public void setData10(String data10) {
		this.data10 = data10;
	}

	public String getData11() {
		return data11;
	}

	public void setData11(String data11) {
		this.data11 = data11;
	}

	public int getData12() {
		return data12;
	}

	public void setData12(int data12) {
		this.data12 = data12;
	}

	public int getData13() {
		return data13;
	}

	public void setData13(int data13) {
		this.data13 = data13;
	}

	public int getData14() {
		return data14;
	}

	public void setData14(int data14) {
		this.data14 = data14;
	}

	public int getData15() {
		return data15;
	}

	public void setData15(int data15) {
		this.data15 = data15;
	}

	public String getData16() {
		return data16;
	}

	public void setData16(String data16) {
		this.data16 = data16;
	}
	
	
	
}
