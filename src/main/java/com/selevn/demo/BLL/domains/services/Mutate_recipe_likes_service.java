package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.ports.in.commands.mutate.Mutate_likes_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Mutate_recipes_likes_use_case;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_recipe_port;
import com.selevn.demo.BLL.domains.ports.out.db.loaders.Load_user_port;
import com.selevn.demo.BLL.domains.ports.out.db.updates.Update_recipe_port;
import com.selevn.demo.BLL.domains.ports.out.db.updates.Update_user_port;

public class Mutate_recipe_likes_service implements Mutate_recipes_likes_use_case {
    private Load_user_port load_user_port;
    private Load_recipe_port load_recipe_port;
    private Update_recipe_port update_recipe_port;
    private Update_user_port update_user_port;

    public Mutate_recipe_likes_service(Load_user_port load_user_port, Load_recipe_port load_recipe_port, Update_recipe_port update_recipe_port, Update_user_port update_user_port) {
        this.load_user_port = load_user_port;
        this.load_recipe_port = load_recipe_port;
        this.update_recipe_port = update_recipe_port;
        this.update_user_port = update_user_port;
    }

    @Override
    public boolean mutate_views(Mutate_likes_command command) {
        var recipe = load_recipe_port.load_recipe(command.get_targetId());
        var user = load_user_port.load_user(command.get_sourceAccountId());
        if(user.get_likedRecipes().contains(recipe))
        {
            user.DislikeRecipe(recipe);
            recipe.removeLike();
        }
        else{
            user.LikeRecipe(recipe);
            recipe.addLike();
        }

        return update_user_port.update_user(user) && update_recipe_port.update_recipe(recipe);
    }
}
