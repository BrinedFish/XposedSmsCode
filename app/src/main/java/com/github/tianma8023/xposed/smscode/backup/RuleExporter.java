package com.github.tianma8023.xposed.smscode.backup;

import com.github.tianma8023.xposed.smscode.entity.SmsCodeRule;
import com.google.gson.stream.JsonWriter;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * SmsCode rules exporter
 */
public class RuleExporter implements Closeable{

    private JsonWriter mJsonWriter;

    public RuleExporter(OutputStream out) {
        OutputStreamWriter osw;
        try {
            osw = new OutputStreamWriter(out, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
        mJsonWriter = new JsonWriter(osw);
        mJsonWriter.setIndent("\t"); // pretty print
    }

    public RuleExporter(File file) throws FileNotFoundException {
        this(new FileOutputStream(file));
    }

    public void doExport(List<SmsCodeRule> ruleList) throws IOException {
        begin();
        exportRuleList(ruleList);
        end();
    }

    private void begin() throws IOException {
        mJsonWriter.beginObject();
        mJsonWriter.name(BackupConst.KEY_VERSION)
                .value(BackupConst.BACKUP_VERSION);
    }

    private void exportRuleList(List<SmsCodeRule> ruleList) throws IOException {
        mJsonWriter.name(BackupConst.KEY_RULES)
                .beginArray();
        for(SmsCodeRule rule : ruleList) {
            exportRule(rule);
        }
        mJsonWriter.endArray();
    }

    private void exportRule(SmsCodeRule rule) throws IOException {
        mJsonWriter.beginObject();
        mJsonWriter.name(BackupConst.KEY_COMPANY).value(rule.getCompany());
        mJsonWriter.name(BackupConst.KEY_CODE_KEYWORD).value(rule.getCodeKeyword());
        mJsonWriter.name(BackupConst.KEY_CODE_REGEX).value(rule.getCodeRegex());
        mJsonWriter.endObject();
    }

    private void end() throws IOException {
        mJsonWriter.endObject();
    }

    @Override
    public void close() {
        if (mJsonWriter != null) {
            try {
                mJsonWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
