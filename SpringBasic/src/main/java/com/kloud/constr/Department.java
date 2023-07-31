package com.kloud.constr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Department {
		String deptname;
		String depthead;
		
		public String getDeptname() {
			return deptname;
		}
		@Value("CSE")
		public void setDeptname(String deptname) {
			this.deptname = deptname;
		}
//		public Department(String deptname) {
//			super();
//			this.deptname = deptname;
//		}
		public String getDepthead() {
			return depthead;
		}
		@Value("David")
		public void setDepthead(String depthead) {
			this.depthead = depthead;
		}
		
}
