package sample.model.modelControllers;
import sample.model.Computer;
import sample.model.Master;
import sample.model.Member;

import java.util.*;
import java.io.Serializable;
/**
 *
 * @author sepehr
 */
public class List implements Serializable {
    LinkedList<Computer> computers = new LinkedList<>();
    LinkedList<Member> members = new LinkedList<>();
    Master master = new Master("admin", "1234");

    public void add(Computer computer)throws Exception{
        for(Computer comp : computers)
            if(computer.getUserName().equals(comp.getUserName()))
                throw new RepetitionUserName();
        computers.add(computer);
    }
    public void add(Member member)throws Exception{
        for(Member m1 : members)
            if(member.getUserName().equals(m1.getUserName()))
                throw new Exception();
        members.add(member);
    }
    public Member searchMembers(String userName)throws Exception{
        for(Member member : members)
            if(userName.equals(member.getUserName()))
                return member;

        throw new Exception();
    }
    public Computer searchComputers(String userName)throws Exception{
        for(Computer computer : computers)
            if(userName.equals(computer.getUserName()))
                return computer;

        throw new Exception();
    }
    public void deleteMembers(String userName)throws Exception{
        members.remove(searchMembers(userName));
    }
    public void deleteComputers(String userName)throws Exception{
        computers.remove(searchComputers(userName));
    }
    public void changeMasterPassword(String password){
        master.setPassword(password);
    }
    public void changeMasterUserName(String userName){
        master.setUserName(userName);
    }

    public LinkedList<Computer> getComputers() {
        return computers;
    }

    public LinkedList<Member> getMembers() {
        return members;
    }

    public Master getMaster() {
        return master;
    }

    public void setComputers(LinkedList<Computer> computers) {
        this.computers = computers;
    }

    public void setMembers(LinkedList<Member> members) {
        this.members = members;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    static class RepetitionUserName extends Exception{
        @Override
        public String toString(){
            return "UserName already taken.";
        }
    }

}
