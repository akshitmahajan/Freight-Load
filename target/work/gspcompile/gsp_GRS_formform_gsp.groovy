import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_GRS_formform_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form/form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('textField','g',10,['name':("lastName")],-1)
printHtmlPart(5)
invokeTag('textField','g',13,['name':("firstName")],-1)
printHtmlPart(6)
invokeTag('textField','g',16,['name':("age")],-1)
printHtmlPart(7)
invokeTag('submitButton','g',18,['name':("create"),'value':("Save")],-1)
printHtmlPart(3)
})
invokeTag('form','g',19,['action':("saveForm")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',20,[:],1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1387180486000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
