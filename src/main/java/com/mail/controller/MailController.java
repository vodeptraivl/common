package com.mail.controller;

import com.mail.domain.EmailDetails;
import com.mail.domain.Mail;
import com.mail.services.MailIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailIml emailService;

    @PostMapping("/notify")
    public String
    sendMail(@RequestBody() Mail mail) throws Exception
    {
        String status = emailService.sendSimpleMail(mail);

        return status;
    }

    @GetMapping("/test")
    public String
    test() throws Exception
    {
        Mail mail = new Mail();
        mail.setSystem("CFB");
        mail.setForm(2);
        mail.setMessage("java.lang.ClassCastException: org.jenkinsci.plugins.workflow.steps.EchoStep.message expects class java.lang.String but received class hudson.AbortException\n" +
                "\tat org.jenkinsci.plugins.structs.describable.DescribableModel.coerce(DescribableModel.java:492)\n" +
                "\tat org.jenkinsci.plugins.structs.describable.DescribableModel.buildArguments(DescribableModel.java:409)\n" +
                "\tat org.jenkinsci.plugins.structs.describable.DescribableModel.instantiate(DescribableModel.java:329)\n" +
                "\tat org.jenkinsci.plugins.workflow.cps.DSL.invokeStep(DSL.java:305)\n" +
                "\tat org.jenkinsci.plugins.workflow.cps.DSL.invokeMethod(DSL.java:196)\n" +
                "\tat org.jenkinsci.plugins.workflow.cps.CpsScript.invokeMethod(CpsScript.java:124)\n" +
                "\tat jdk.internal.reflect.GeneratedMethodAccessor452.invoke(Unknown Source)\n" +
                "\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n" +
                "\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\n" +
                "\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\n" +
                "\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\n" +
                "\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\n" +
                "\tat org.codehaus.groovy.runtime.callsite.PogoMetaClassSite.call(PogoMetaClassSite.java:41)\n" +
                "\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\n" +
                "\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:116)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker$1.call(Checker.java:180)\n" +
                "\tat org.kohsuke.groovy.sandbox.GroovyInterceptor.onMethodCall(GroovyInterceptor.java:23)\n" +
                "\tat org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SandboxInterceptor.onMethodCall(SandboxInterceptor.java:163)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker$1.call(Checker.java:178)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker.checkedCall(Checker.java:182)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker.checkedCall(Checker.java:152)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker.checkedCall(Checker.java:152)\n" +
                "\tat com.cloudbees.groovy.cps.sandbox.SandboxInvoker.methodCall(SandboxInvoker.java:17)\n" +
                "Also:   org.jenkinsci.plugins.workflow.actions.ErrorAction$ErrorId: ee3c5688-6375-46ac-a102-282df23302a8\n" +
                "Caused: java.lang.IllegalArgumentException: Could not instantiate {message=hudson.AbortException: script returned exit code 1} for org.jenkinsci.plugins.workflow.steps.EchoStep\n" +
                "\tat org.jenkinsci.plugins.structs.describable.DescribableModel.instantiate(DescribableModel.java:334)\n" +
                "\tat org.jenkinsci.plugins.workflow.cps.DSL.invokeStep(DSL.java:305)\n" +
                "\tat org.jenkinsci.plugins.workflow.cps.DSL.invokeMethod(DSL.java:196)\n" +
                "\tat org.jenkinsci.plugins.workflow.cps.CpsScript.invokeMethod(CpsScript.java:124)\n" +
                "\tat jdk.internal.reflect.GeneratedMethodAccessor452.invoke(Unknown Source)\n" +
                "\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "\tat java.base/java.lang.reflect.Method.invoke(Method.java:566)\n" +
                "\tat org.codehaus.groovy.reflection.CachedMethod.invoke(CachedMethod.java:98)\n" +
                "\tat groovy.lang.MetaMethod.doMethodInvoke(MetaMethod.java:325)\n" +
                "\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1225)\n" +
                "\tat groovy.lang.MetaClassImpl.invokeMethod(MetaClassImpl.java:1034)\n" +
                "\tat org.codehaus.groovy.runtime.callsite.PogoMetaClassSite.call(PogoMetaClassSite.java:41)\n" +
                "\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:47)\n" +
                "\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:116)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker$1.call(Checker.java:180)\n" +
                "\tat org.kohsuke.groovy.sandbox.GroovyInterceptor.onMethodCall(GroovyInterceptor.java:23)\n" +
                "\tat org.jenkinsci.plugins.scriptsecurity.sandbox.groovy.SandboxInterceptor.onMethodCall(SandboxInterceptor.java:163)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker$1.call(Checker.java:178)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker.checkedCall(Checker.java:182)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker.checkedCall(Checker.java:152)\n" +
                "\tat org.kohsuke.groovy.sandbox.impl.Checker.checkedCall(Checker.java:152)\n" +
                "\tat com.cloudbees.groovy.cps.sandbox.SandboxInvoker.methodCall(SandboxInvoker.java:17)");
        mail.setCommitId("4f6ee8e0087f5f004c0ee94793b90770fcd06c77");
        mail.setError(true);
        String status = emailService.sendSimpleMail(mail);

        return status;
    }
}
