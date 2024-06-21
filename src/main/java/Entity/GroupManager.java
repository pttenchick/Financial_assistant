package Entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

//Класс-коллекция со всеми группами; Class-collection with all groups
public class GroupManager {

    private static final Logger logger = LoggerFactory.getLogger(GroupManager.class);

    private static HashMap<String, Group> groups = new HashMap<>();

    //Получить группу по названию, а если такой группы нет, то создать новую; Get a gpoup by name, and if there
    // is no such group, then create a new one
    public static Group getOrCreateGroup(String groupName){
        if(!groups.containsKey(groupName)){
            Group newGroup = new Group(groupName);
            groups.put(groupName, newGroup);
            logger.info("Новая группа {} создана", groupName);
        }
        return groups.get(groupName);
    }
}
