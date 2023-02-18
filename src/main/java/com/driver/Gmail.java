package com.driver;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)


    ArrayList<EmailTemp> Inbox;
    ArrayList<EmailTemp> Trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
       this.Inbox = new ArrayList<>();
       this.Trash = new ArrayList<>();




    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.


        if(Inbox.size() == inboxCapacity){

            EmailTemp emailTemplate = Inbox.get(0);
            Inbox.remove(0);
            Trash.add(emailTemplate);
        }

        EmailTemp emailTemplate = new EmailTemp(date, sender , message);
        Inbox.add(emailTemplate);

    }

    public void deleteMail(String message){


        EmailTemp emailTemplate = null;
        for(int i=0; i<Inbox.size(); i++){
            EmailTemp emailTemplate1 = Inbox.get(i);
            if(emailTemplate1.message.equals(message)){
                emailTemplate = emailTemplate1;
                break;
            }
        }
        if(emailTemplate != null){
            Inbox.remove(emailTemplate);
            Trash.add(emailTemplate);
        }
    }

    public String findLatestMessage(){

        if(Inbox.isEmpty()){
            return null;
        }


        EmailTemp emailTemplate = Inbox.get(Inbox.size() - 1);
        return emailTemplate.message;
    }

    public String findOldestMessage(){


        if(Inbox.isEmpty()){
            return null;
        }


        EmailTemp emailTemplate = Inbox.get(0);
        return emailTemplate.message;
    }

    public int findMailsBetweenDates(Date start, Date end){


        int count = 0;
        for(int i=0; i<Inbox.size(); i++){
            EmailTemp emailTemplate = Inbox.get(i);
            //Compare the Date
            if((emailTemplate.date.compareTo(start) >= 0) && (emailTemplate.date.compareTo(end) <= 0)){
                count++;
            }
        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
 class EmailTemp {
    Date date;
    String sender;
    String message;



    public EmailTemp(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }
}

