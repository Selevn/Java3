package com.selevn.demo.BLL.domains.services;

import com.selevn.demo.BLL.domains.ports.in.commands.create.Create_cookBook_command;
import com.selevn.demo.BLL.domains.ports.in.use_cases.Create_cookBook_use_case;
import com.selevn.demo.BLL.domains.ports.out.db.uploaders.Upload_cookBook_port;

public class Create_cookBook_service implements Create_cookBook_use_case {
    private Upload_cookBook_port _uploadCookBook;

    public Create_cookBook_service(Upload_cookBook_port _uploadCookBook) {
        this._uploadCookBook = _uploadCookBook;
    }

    @Override
    public boolean Create_cookBook(Create_cookBook_command book_command) {

        return _uploadCookBook.upload_cookBook(book_command.get_cookBook());
    }
}
