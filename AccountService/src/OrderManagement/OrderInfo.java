package OrderManagement;

public class OrderInfo {

public String getStart_time() {
	return start_time;
}

public void setStart_time(String start_time) {
	this.start_time = start_time;
}

public int getStart_loc() {
	return start_loc;
}

public void setStart_loc(int start_loc) {
	this.start_loc = start_loc;
}

public int getEmployee_id() {
	return employee_id;
}

public void setEmployee_id(int employee_id) {
	this.employee_id = employee_id;
}

public int getEnd_loc() {
	return end_loc;
}

public void setEnd_loc(int end_loc) {
	this.end_loc = end_loc;
}

public int getDistance() {
	return distance;
}

public void setDistance(int distance) {
	this.distance = distance;
}

public int getPayment() {
	return payment;
}

public void setPayment(int payment) {
	this.payment = payment;
}

public String getEnd_time() {
	return end_time;
}

public void setEnd_time(String end_time) {
	this.end_time = end_time;
}
private String start_time;
private int start_loc;
private int employee_id;

private int end_loc;
private int distance;
private int payment;
private String end_time;



public OrderInfo(String start_time,int start_loc) 
{
	this.employee_id = 1;
	this.start_time=start_time;
	this.start_loc=start_loc;
	this.end_loc=0;
	this.distance=0;
	this.payment=0;
	this.end_time="ongoing";
	
}

public void updateOrderInfo(int end_loc,int distance,int payment,String end_time) 
{
	this.end_loc=end_loc;
	this.distance=distance;
	this.payment=payment;
	this.end_time=end_time;
}



}
