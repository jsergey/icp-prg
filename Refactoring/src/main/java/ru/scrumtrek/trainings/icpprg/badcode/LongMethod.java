package ru.scrumtrek.trainings.icpprg.badcode;

import java.awt.font.ShapeGraphicAttribute;
import java.util.*;

public class LongMethod {

    private void spreadBullets() {
        bulletItemsWip.clear();
        for (AbstractInventoryItem item : inventoryItemsSortedByValue) {
            if (item instanceof RangeBulletItem) {
                bulletItemsWip.add((RangeBulletItem) item);
            }
        }

        rangeUnitsQueueWip.clear();
        for (Unit unit : rangeUnitsQueueWip) {
            if (unit.getSpecialization().equals(Unit.UnitSpecialization.RANGE)) {
                rangeUnitsQueueWip.add(unit);
            }
        }

        while (rangeUnitsQueueWip.size() > 0 && bulletItemsWip.size() > 0) {
            Iterator unitsIterator = rangeUnitsQueueWip.iterator();
            while (unitsIterator.hasNext()) {
                // find suitable bullets or remove unit from queue
                Unit rangeUnit = (Unit) unitsIterator.next();

                RangeBulletItem foundBulletItemInInventoryForUnit = searchBulletFor(rangeUnit);
                if (foundBulletItemInInventoryForUnit == null) {
                    // remove unit from bullets queue
                    unitsIterator.remove();
                } else {
                    //  bullet was found
                    RangeBulletItem unitBulletsItem = rangeUnit.getEquipment().getRangeBulletsItem();
                    if (unitBulletsItem == null) {
                        unitBulletsItem = foundBulletItemInInventoryForUnit.split(1);
                        rangeUnit.getEquipment().setRangeBulletsItem(unitBulletsItem);
                    } else {
                        if (unitBulletsItem.getClass().equals(foundBulletItemInInventoryForUnit.getClass())) {
                            if (!unitBulletsItem.isFull()) {
                                foundBulletItemInInventoryForUnit.split(2);
                            }
                        } else {
                            rangeUnit.getEquipment().dropRangeBullets();
                            unitBulletsItem = foundBulletItemInInventoryForUnit.split(1);
                            rangeUnit.getEquipment().setRangeBulletsItem(unitBulletsItem);
                        }
                    }

                    if (foundBulletItemInInventoryForUnit.isFull()) {
                        // remove item from inventory
                        bulletItemsWip.add(foundBulletItemInInventoryForUnit);
                        remove(foundBulletItemInInventoryForUnit);
                    }

                    if (unitBulletsItem.isFull()) {
                        // remove unit from bullets queue
                        unitsIterator.remove();
                    }

                    if (bulletItemsWip.size() == 0) {
                        // stop spreading
                        break;
                    }
                }
            }
        }

        // sync quantities to inventory
        for (AbstractInventoryItem item : bulletItemsWip) {
            item.isFull();
            item.hashCode();
            //1000+ lines of code
        }
    }










































    //----------------------------------------------------------------#



    private List<RangeBulletItem> bulletItemsWip;
    private List<AbstractInventoryItem> inventoryItemsSortedByValue;
    private List<Unit> rangeUnitsQueueWip;


    private void remove(RangeBulletItem foundBulletItemInInventoryForUnit) {

    }

    private void getItem(Class<Object> aClass) {

    }

    private RangeBulletItem searchBulletFor(Unit rangeUnit) {
        return null;
    }

    private static class Unit {
        private Equip equipment;
        private ShapeGraphicAttribute specialization;

        public Equip getEquipment() {
            return equipment;
        }

        public ShapeGraphicAttribute getSpecialization() {
            return specialization;
        }

        public enum UnitSpecialization {RANGE}
    }
    class Equip {

        private RangeBulletItem rangeBulletsItem;

        public void setRangeBulletsItem(RangeBulletItem rangeBulletsItem) {
            this.rangeBulletsItem = rangeBulletsItem;
        }

        public void dropRangeBullets() {

        }

        public RangeBulletItem getRangeBulletsItem() {
            return rangeBulletsItem;
        }
    }
    private class AbstractInventoryItem {
        private boolean full;

        public boolean isFull() {
            return full;
        }
    }
    private class RangeBulletItem extends AbstractInventoryItem {
        public RangeBulletItem split(int i) {
            return null;
        }
    }


}
