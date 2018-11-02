package com.laoying.service.impl;

import com.laoying.dao.AttendanceDao;
import com.laoying.dao.AwardPunishDao;
import com.laoying.dao.EmployeeDao;
import com.laoying.dao.SalaryDao;
import com.laoying.model.Attendance;
import com.laoying.model.Employee;
import com.laoying.model.Salary;
import com.laoying.service.SalaryService;
import com.laoying.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private AttendanceDao attendanceDao;
    @Autowired
    private AwardPunishDao awardPunishDao;
    public List<Salary> getSalary() {
        return salaryDao.getSalary();
    }

    public boolean addSalary(Salary salary) {
        List<Employee> employees =employeeDao.getAllEmp();//找到在职所有员工
        for (int i = 0; i <employees.size() ; i++) {
            //找到该员工未旷工前一个月的打卡信息
            List<Attendance> attendances=attendanceDao.getAttendance(employees.get(i).getEmp_id());
            if (attendances.size()!=0){
                List<Attendance> att = new ArrayList<Attendance>();//未旷工打卡记录放进来
                List<Attendance> att1 = new ArrayList<Attendance>();//正常打卡记录放进来
                for (int j = 0; j <attendances.size() ; j++) {
                    if (attendances.get(j).getA_down_work()!=null && attendances.get(j).getA_state()!=2){
                        att.add(attendances.get(j));
                        if (attendances.get(j).getA_state()==0){
                            att1.add(attendances.get(j));
                        }
                    }
                }
                //打卡记录（未旷工）超过22条视为加班，多加200
                //加班钱
                double workMoney=0;
                if (att.size()>22){
                    workMoney=200;
                }
                //绩效
                double performance=0;
                if (att1.size()>=22){
                    performance=300;
                }
                //日薪
                double date_salary = employees.get(i).getEmp_salary()/22;
                //社保
                double money =employees.get(i).getEmp_salary()/10;
                //奖惩表中金额
                double money1 =awardPunishDao.getAp(employees.get(i).getEmp_id());
                //迟到早退金额
                int count1=att.size()-att1.size();
                double money4=count1*50;
                //员工应该得的金额
                double totalMoney=0;
                if (att.size()>=22){
                    totalMoney=employees.get(i).getEmp_salary()+performance
                            +workMoney-money+money1 -money4;
                }else {
                    totalMoney=date_salary*att.size()+performance
                            +workMoney-money+money1 -money4;
                }

                if (totalMoney<0){
                    totalMoney=0;
                }
                salary.setS_salary(totalMoney);
                salary.setEmp_id(employees.get(i).getEmp_id());
                salary.setS_date(MyUtil.toString(new Date()));
                salary.setS_performance(performance);
                salary.setS_work_overtime(workMoney);
                salary.setS_social_security(money);
                salaryDao.addSalary(salary);

            }
        }
        return true;
    }

    public List<Salary> getSalaries(int emp_id) {
        return salaryDao.getSalaries(emp_id);
    }
}
