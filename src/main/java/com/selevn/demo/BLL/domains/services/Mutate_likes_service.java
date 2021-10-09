package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_views_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Mutate_likes_use_case;

public class Mutate_likes_service implements Mutate_likes_use_case {

    @Override
    public boolean mutate_views(Mutate_views_command command) {
        return false;
    }
}
