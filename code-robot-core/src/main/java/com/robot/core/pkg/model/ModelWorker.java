package com.robot.core.pkg.model;

import java.util.List;
import java.util.Objects;

import com.robot.core.config.PkgConfig;
import com.robot.core.db.ITypeConvert;
import com.robot.core.db.po.TableField;
import com.robot.core.db.po.TableInfo;
import com.robot.core.exception.ExceptionUtil;
import com.robot.core.pkg.ModelCacheTool;
import com.robot.core.pkg.model.creator.ControllerTestExportDecorator;
import com.robot.core.pkg.model.creator.ModelExportDecorator;
import com.robot.core.pkg.model.name.INameConvert;
import com.robot.core.pkg.model.name.impl.NamingStrategy;
import com.robot.core.pkg.model.po.Clazz;
import com.robot.core.pkg.model.po.ClazzField;
import com.robot.core.pkg.model.transform.ITransform;
import com.robot.core.pkg.model.transform.TransformDirector;
import com.robot.core.pkg.model.transform.builder.CommonTransformBuilder;
import com.robot.core.pkg.model.transform.builder.ModelTransformBuilder;

/**
 * bean、mapper、service、controller模块的生成工作
 *
 */
public class ModelWorker {


    public void work(PkgConfig pkgConfig, TableInfo table, List<TableField> fields) {
        try {
            /**--------------------------bean创建--------------------------*/
            ITransform mts = TransformDirector.createTransform(ModelTransformBuilder.build(getNameConvert(), getTypeConvert(), table, fields));
            ModelExportDecorator beanDecorator = new ModelExportDecorator(mts);
            beanDecorator.out(pkgConfig.getPkgPath(), pkgConfig.getModuleName(), pkgConfig.getBean());
            /**--------------------------bean创建--------------------------*/

            Clazz clazz = mts.clazz();
            List<ClazzField> clazzFields = mts.clazzFields(clazz);
            ModelCacheTool.me().cache(clazz, clazzFields);
            
            /**--------------------------mapper、service、controller创建--------------------------*/
            ITransform cts = TransformDirector.createTransform(CommonTransformBuilder.build(clazz, clazzFields));
            ModelExportDecorator decorator = new ModelExportDecorator(cts);
            //mapper
            decorator.out(pkgConfig.getPkgPath(), pkgConfig.getModuleName(), pkgConfig.getMapper());
            //service
            decorator.out(pkgConfig.getPkgPath(), pkgConfig.getModuleName(), pkgConfig.getService());
            //controller
            decorator.out(pkgConfig.getPkgPath(), pkgConfig.getModuleName(), pkgConfig.getController());
            /**--------------------------mapper、service、controller创建--------------------------*/

            /**--------------------------controllerTest创建--------------------------*/
            ControllerTestExportDecorator testDecorator = new ControllerTestExportDecorator(cts);
            testDecorator.out(pkgConfig.getPkgPath(), pkgConfig.getModuleName(), pkgConfig.getController());
            /**--------------------------controllerTest创建--------------------------*/
        } catch (Exception e) {
            throw ExceptionUtil.throwRE("base on table: {%s} build ERROR", e, table.getName());
        }
    }

    private INameConvert nameConvert;
    public void setNameConvert(INameConvert nameConvert) {
        this.nameConvert = nameConvert;
    }
    public INameConvert getNameConvert() {
        if(Objects.isNull(nameConvert)) {
            nameConvert = new NamingStrategy();
        }
        return nameConvert;
    }

    private ITypeConvert typeConvert;
    public void setTypeConvert(ITypeConvert typeConvert) {
        this.typeConvert = typeConvert;
    }
    public ITypeConvert getTypeConvert() {
        if(Objects.isNull(typeConvert)) {
            throw ExceptionUtil.throwRE("ITypeConvert need be init");
        }
        return typeConvert;
    }
}
