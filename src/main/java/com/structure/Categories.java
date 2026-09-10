package com.structure;

public enum Categories {
    Xiaomi(null, "xiaomi-store"),
    ElectroCars(null, "elektromobili"),
    XiaomiSmartWatch(Xiaomi, "smart-chasy"),
    XiaomiGlassesVirtualReality(Xiaomi, "ochki-virtual-noj-real-nosti");

    private final Categories parent;
    private final String path;

    Categories(Categories parent, String element) {
        this.parent = parent;
        if (parent == null) {
            path = String.format("//nav//li[.//a[contains(@href,'%s')]]", element);
        } else {
            path = parent.path + String.format("//a[contains(@href,'%s')]", element);
        }
    }

    public Categories getParent() {
        return parent;
    }

    public String getPath() {
        return path;
    }
}
