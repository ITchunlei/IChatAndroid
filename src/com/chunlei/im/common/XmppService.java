package com.chunlei.im.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;
public class XmppService{
    public static boolean deleteAccount(XMPPConnection connection)  
    {  
        try {  
            /*connection.getAccountManager().deleteAccount();  */
        	connection.disconnect();
            return true;  
        } catch (Exception e) {  
            return false;  
        }  
    }  
	public static List<RosterGroup> getGroups(Roster roster) {
		List<RosterGroup> groupsList = new ArrayList<RosterGroup>();
		Collection<RosterGroup> rosterGroup = roster.getGroups();
		Iterator<RosterGroup> i = rosterGroup.iterator();
		while (i.hasNext())
			groupsList.add(i.next());
		return groupsList;
	}
	public static List<RosterEntry> getEntriesByGroup(Roster roster,
			String groupName) {
		List<RosterEntry> EntriesList = new ArrayList<RosterEntry>();
		RosterGroup rosterGroup = roster.getGroup(groupName);
		Collection<RosterEntry> rosterEntry = rosterGroup.getEntries();
		Iterator<RosterEntry> i = rosterEntry.iterator();
		while (i.hasNext())
			EntriesList.add(i.next());
		return EntriesList;
	}

	public static List<RosterEntry> getAllEntries(Roster roster) {
		List<RosterEntry> EntriesList = new ArrayList<RosterEntry>();
		Collection<RosterEntry> rosterEntry = roster.getEntries();
		Iterator<RosterEntry> i = rosterEntry.iterator();
		while (i.hasNext())
			EntriesList.add(i.next());
		return EntriesList;
	}
	public static boolean addGroup(Roster roster,String groupName)  
    {  
        try {  
            roster.createGroup(groupName);  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
    }   
    public static boolean removeGroup(Roster roster,String groupName)  
    {  
        return false;  
    }

	public static boolean addUser(Roster roster,String userName,String name)
	{
		try {
			roster.createEntry(userName, name, null);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public static boolean addUsers(Roster roster,String userName,String name,String groupName)
	{
		try {
			roster.createEntry(userName, name,new String[]{ groupName});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public static boolean removeUser(Roster roster,String userJid)
	{
		try {
			RosterEntry entry = roster.getEntry(userJid);
			roster.removeEntry(entry);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}

    public static void addUserToGroup(final String userJid, final String groupName,
            final XMPPConnection connection) {
            	RosterGroup group = connection.getRoster().getGroup(groupName);
                RosterEntry entry = connection.getRoster().getEntry(userJid);
                try {
                    if (group != null) {
                        if (entry != null)
                            group.addEntry(entry);
                    } else {
                        RosterGroup newGroup = connection.getRoster().createGroup("????????");
                        if (entry != null)
                            newGroup.addEntry(entry);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
    }

    public static void removeUserFromGroup(final String userJid,final String groupName, final XMPPConnection connection) {
            RosterGroup group = connection.getRoster().getGroup(groupName);
            if (group != null) {
                try {
                	RosterEntry entry = connection.getRoster().getEntry(userJid);
                    if (entry != null)
                        group.removeEntry(entry);
                } catch (XMPPException e) {
                    e.printStackTrace();
                }
            }
     }
    public static void changeStateMessage(final XMPPConnection connection,final String status)  
    {  
        Presence presence = new Presence(Presence.Type.available);  
        presence.setStatus(status);  
        connection.sendPacket(presence);      
    }  
}
