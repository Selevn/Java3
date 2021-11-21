package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_likes_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Mutate_cookBook_likes_use_case;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_cookBook_port;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_user_port;
import com.selevn.demo.BLL.domains.ports.out.db.updates.Update_cookBook_port;
import com.selevn.demo.BLL.domains.ports.out.db.updates.Update_user_port;

public class Mutate_cookBooks_likes_service implements Mutate_cookBook_likes_use_case {
    private Load_cookBook_port load_cookBook_port;
    private Load_user_port load_user_port;
    private Update_cookBook_port update_cookBook_port;
    private Update_user_port update_user_port;

    public Mutate_cookBooks_likes_service(Load_cookBook_port load_cookBook_port, Load_user_port load_user_port, Update_cookBook_port update_cookBook_port, Update_user_port update_user_port) {
        this.load_cookBook_port = load_cookBook_port;
        this.load_user_port = load_user_port;
        this.update_cookBook_port = update_cookBook_port;
        this.update_user_port = update_user_port;
    }


    @Override
    public boolean mutate_views(Mutate_likes_command command) {
        var book = load_cookBook_port.load_cookBook(command.get_targetId());
        var user = load_user_port.load_user(command.get_sourceAccountId());
        if(user.get_likedCookBooks().contains(book))
        {
            user.DislikeCookBook(book);
            book.removeLike();
        }
        else{
            user.LikeCookBook(book);
            book.addLike();
        }

        return update_user_port.update_user(user) && update_cookBook_port.update_cookBook(book);
    }
}
