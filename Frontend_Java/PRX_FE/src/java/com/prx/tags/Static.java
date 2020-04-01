/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prx.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.prx.util.AppContext;

/**
 *
 * @author Admin
 */
public class Static extends SimpleTagSupport {

    private String type;
    private String path;
    private String cls = "";

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            AppContext ac = new AppContext();
            String content = ac.env("contextPath");

            if (null != type) {
                switch (type) {
                    case "img": {
                        String url = content + "/" + ac.env("img") + "/" + path;
                        content = "<img class='" + cls + "' src='" + url + "'/>";
                        break;
                    }
                    case "css": {
                        String url = content + "/" + ac.env("css") + "/" + path;
                        content = "<link rel='stylesheet' href='" + url + "'/>";
                        break;
                    }
                    case "script": {
                        String url = content + "/" + ac.env("script") + "/" + path;
                        content = "<script type='text/javascript' src='" + url + "'/>";
                        break;
                    }
                    case "api": {
                        content = ac.env("apiURL");
                        break;
                    }
                    default:
                        break;
                }
            }

            out.print(content);

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Static tag", ex);
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

}
