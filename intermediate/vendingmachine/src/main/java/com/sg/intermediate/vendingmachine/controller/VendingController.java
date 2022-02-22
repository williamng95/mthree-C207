package com.sg.intermediate.vendingmachine.controller;

import com.sg.intermediate.vendingmachine.service.VendingService;
import com.sg.intermediate.vendingmachine.ui.VendingView;

public class VendingController {
    private VendingService service;
    private VendingView ui;

    /**
     * @param dao
     * @param ui
     */
    public VendingController(VendingService service, VendingView ui) {
        this.service = service;
        this.ui = ui;
    }

    public void run() {

    }

}
