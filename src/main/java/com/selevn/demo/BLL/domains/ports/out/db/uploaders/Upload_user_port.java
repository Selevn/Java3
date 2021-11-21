package com.selevn.demo.BLL.domains.ports.out.db.uploaders;

import com.selevn.demo.BLL.domains.entities.User;

public interface Upload_user_port {
    public boolean upload_user(User user);
}
