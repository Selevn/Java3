package com.selevn.demo.BLL.domains.ports.out.db.uploaders;

import com.selevn.demo.BLL.domains.entities.CookBook;

import java.util.ArrayList;

public interface Upload_cookBook_port {
    public boolean upload_cookBook(CookBook cookBook);
}
