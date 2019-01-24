/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import com.swcguild.vendingmachine.dao.VendingMachineDao;
import com.swcguild.vendingmachine.dto.VendingMachineItem;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao {

    private VendingMachineItem onlyValidItem;
    private VendingMachineItem invalidItem;
    private Map<Integer, VendingMachineItem> itemList = new HashMap<>();

    public VendingMachineDaoStubImpl() {
        onlyValidItem = new VendingMachineItem(1);
        onlyValidItem.setItemName("Sprite");
        onlyValidItem.setItemCount(1);
        onlyValidItem.setItemPrice(new BigDecimal("1.00"));

        itemList.put(onlyValidItem.getItemId(), onlyValidItem);

        invalidItem = new VendingMachineItem(2);
        invalidItem.setItemName("Dr. Pepper");
        invalidItem.setItemCount(0);
        invalidItem.setItemPrice(new BigDecimal("1.50"));

        itemList.put(2, invalidItem);

    }

    @Override
    public void create(VendingMachineItem item) {
        itemList.put(item.getItemId(), item);
    }

    @Override
    public List<VendingMachineItem> readAll() {
        return new ArrayList<>(itemList.values());
    }

    @Override
    public VendingMachineItem readByID(int itemId) {
        if (itemList.containsKey(itemId)) {
            return itemList.get(itemId);
        } else {
            return null;
        }
    }

    @Override
    public void update(int itemId, VendingMachineItem item) {
        if (itemId == onlyValidItem.getItemId()) {
            if (onlyValidItem.getItemName().equals(item.getItemName())) {
            } else {
                onlyValidItem.setItemName(item.getItemName());
            }

            if (onlyValidItem.getItemCount() == item.getItemCount()) {
            } else {
                onlyValidItem.setItemCount(item.getItemCount());
            }

            if (onlyValidItem.getItemPrice().equals(item.getItemPrice())) {
            } else {
                onlyValidItem.setItemPrice(item.getItemPrice());
            }
        }
    }
}
