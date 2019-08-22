package com.niit.bean;
import javax.persistence.*;
@Entity
@Table
public class UserInfo {
	@Id
	    String username;
	    String password;
	    String role;
	    boolean enabled;
	    String customerName;
	    String customerAddr;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getCustomerAddr() {
			return customerAddr;
		}
		public void setCustomerAddr(String customerAddr) {
			this.customerAddr = customerAddr;
		}
	    
}
