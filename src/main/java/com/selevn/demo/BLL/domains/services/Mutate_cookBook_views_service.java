package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_views_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Mutate_recipe_views_use_case;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_cookBook_port;
import com.selevn.demo.BLL.domains.ports.out.db.updates.Update_cookBook_port;

public class Mutate_cookBook_views_service implements Mutate_recipe_views_use_case {
    private Load_cookBook_port load_cookBook_port;
    private Update_cookBook_port update_cookBook_port;

    public Mutate_cookBook_views_service(Load_cookBook_port load_cookBook_port, Update_cookBook_port update_cookBook_port) {
        this.load_cookBook_port = load_cookBook_port;
        this.update_cookBook_port = update_cookBook_port;
    }

    @Override
    public boolean mutate_views(Mutate_views_command command) {
        var book = load_cookBook_port.load_cookBook(command.get_targetId());
        book.addView();
        return update_cookBook_port.update_cookBook(book);
    }
}
