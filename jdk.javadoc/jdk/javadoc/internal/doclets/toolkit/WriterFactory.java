/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.javadoc.internal.doclets.toolkit;

import javax.lang.model.element.Element;
import javax.lang.model.element.ModuleElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

import jdk.javadoc.internal.doclets.toolkit.util.ClassTree;
import jdk.javadoc.internal.doclets.toolkit.util.VisibleMemberTable;

/**
 * The interface for a factory creates writers.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Jamie Ho
 */

public interface WriterFactory {

    /**
     * Return the writer for the constant summary.
     *
     * @return the writer for the constant summary.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract ConstantsSummaryWriter getConstantsSummaryWriter();

    /**
     * Return the writer for the package summary.
     *
     * @param packageElement the package being documented.
     * @return the writer for the package summary.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract PackageSummaryWriter getPackageSummaryWriter(PackageElement packageElement);

    /**
     * Return the writer for the module summary.
     *
     * @param mdle the module being documented.
     * @return the writer for the module summary.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract ModuleSummaryWriter getModuleSummaryWriter(ModuleElement mdle);

    /**
     * Return the writer for a class.
     *
     * @param typeElement the class being documented.
     * @param classTree the class tree.
     * @return the writer for the class.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract ClassWriter getClassWriter(TypeElement typeElement, ClassTree classTree);

    /**
     * Return the writer for an annotation type.
     *
     * @param annotationType the type being documented.
     * @return the writer for the annotation type.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract AnnotationTypeWriter getAnnotationTypeWriter(TypeElement annotationType);

    /**
     * Return the method writer for a given class.
     *
     * @param classWriter the writer for the class being documented.
     * @return the method writer for the give class.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract MethodWriter getMethodWriter(ClassWriter classWriter);

    /**
     * Return the annotation type field writer for a given annotation type.
     *
     * @param annotationTypeWriter the writer for the annotation type
     *        being documented.
     * @return the member writer for the given annotation type.  Return null if
     *         this writer is not supported by the doclet.
     */
    public abstract AnnotationTypeFieldWriter
            getAnnotationTypeFieldWriter(
        AnnotationTypeWriter annotationTypeWriter);

    /**
     * Return the annotation type optional member writer for a given annotation
     * type.
     *
     * @param annotationTypeWriter the writer for the annotation type
     *        being documented.
     * @return the member writer for the given annotation type.  Return null if
     *         this writer is not supported by the doclet.
     */
    public abstract AnnotationTypeOptionalMemberWriter
            getAnnotationTypeOptionalMemberWriter(
        AnnotationTypeWriter annotationTypeWriter);

    /**
     * Return the annotation type required member writer for a given annotation type.
     *
     * @param annotationTypeWriter the writer for the annotation type
     *        being documented.
     * @return the member writer for the given annotation type.  Return null if
     *         this writer is not supported by the doclet.
     */
    public abstract AnnotationTypeRequiredMemberWriter
            getAnnotationTypeRequiredMemberWriter(
        AnnotationTypeWriter annotationTypeWriter);

    /**
     * Return the enum constant writer for a given class.
     *
     * @param classWriter the writer for the class being documented.
     * @return the enum constant writer for the give class.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract EnumConstantWriter getEnumConstantWriter(
        ClassWriter classWriter);

    /**
     * Return the field writer for a given class.
     *
     * @param classWriter the writer for the class being documented.
     * @return the field writer for the give class.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract FieldWriter getFieldWriter(ClassWriter classWriter);

    /**
     * Return the property writer for a given class.
     *
     * @param classWriter the writer for the class being documented.
     * @return the property writer for the give class.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract PropertyWriter getPropertyWriter(ClassWriter classWriter);

    /**
     * Return the constructor writer for a given class.
     *
     * @param classWriter the writer for the class being documented.
     * @return the method writer for the give class.  Return null if this
     * writer is not supported by the doclet.
     */
    public abstract ConstructorWriter getConstructorWriter(
        ClassWriter classWriter);

    /**
     * Return the specified member summary writer for a given class.
     *
     * @param classWriter the writer for the class being documented.
     * @param memberType  the {@link VisibleMemberTable} member type indicating
     *                    the type of member summary that should be returned.
     * @return the summary writer for the give class.  Return null if this
     * writer is not supported by the doclet.
     *
     * @see VisibleMemberTable
     */
    public abstract MemberSummaryWriter getMemberSummaryWriter(
        ClassWriter classWriter, VisibleMemberTable.Kind memberType);

    /**
     * Return the specified member summary writer for a given annotation type.
     *
     * @param annotationTypeWriter the writer for the annotation type being
     *                             documented.
     * @param memberType  the {@link VisibleMemberTable} member type indicating
     *                    the type of member summary that should be returned.
     * @return the summary writer for the give class.  Return null if this
     * writer is not supported by the doclet.
     *
     * @see VisibleMemberTable
     */
    public abstract MemberSummaryWriter getMemberSummaryWriter(
        AnnotationTypeWriter annotationTypeWriter, VisibleMemberTable.Kind memberType);

    /**
     * Return the writer for the serialized form.
     *
     * @return the writer for the serialized form.
     */
    public SerializedFormWriter getSerializedFormWriter();

    /**
     * Return the handler for doc files.
     *
     * @return the handler for the doc files.
     */
    DocFilesHandler getDocFilesHandler(Element pkg);
}
