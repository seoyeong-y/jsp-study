package jspbook.ch02;

public class CalcBean {
//필드 변수
	private int num1=0, num2=0;
	private String operator="";
	private int result;
	
//계산 기능 메서드
	public void calculate() {
		if(operator.equals("+")) {
			result = num1 + num2;
		}
		else if(operator.equals("-")) {
			result = num1 - num2;
		}
		else if(operator.equals("*")) {
			result = num1 * num2;
		}
		else if(operator.equals("/")) {
			result = num1 / num2;
		}
	}

//setXxx 메서드
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setResult(int result) {
		this.result = result;
	}

//getXxx 메서드
	public int getResult() {
		return result;
	}
}

