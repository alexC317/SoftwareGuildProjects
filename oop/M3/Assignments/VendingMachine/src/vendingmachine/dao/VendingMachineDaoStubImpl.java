/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendingmachine.dto.VendingMachineItem;

public class VendingMachineDaoStubImpl implements VendingMachineDao {

    private VendingMachineItem onlyItem;
    private Map<Integer, VendingMachineItem> itemList = new HashMap<>();

    public VendingMachineDaoStubImpl() {
        onlyItem = new VendingMachineItem(1);
        onlyItem.setItemName("Sprite");
        onlyItem.setItemCount(1);
        onlyItem.setItemPrice(new BigDecimal("1.00"));

        itemList.put(onlyItem.getItemId(), onlyItem);
    }

    @Override
    public List<VendingMachineItem> readAll() {
        return new ArrayList<>(itemList.values());
    }

    @Override
    public VendingMachineItem readByID(int itemId) {
        if (itemId == onlyItem.getItemId()) {
            return onlyItem;
        } else {
            return null;
        }
    }

    @Override
    public void update(int itemId, VendingMachineItem item) {
        if (itemId == onlyItem.getItemId()) {
            if (onlyItem.getItemName().equals(item.getItemName())) {
            } else {
                onlyItem.setItemName(item.getItemName());
            }

            if (onlyItem.getItemCount() == item.getItemCount()) {
            } else {
                onlyItem.setItemCount(item.getItemCount());
            }

            if (onlyItem.getItemPrice().equals(item.getItemPrice())) {
            } else {
                onlyItem.setItemPrice(item.getItemPrice());
            }
        }
    }

}
