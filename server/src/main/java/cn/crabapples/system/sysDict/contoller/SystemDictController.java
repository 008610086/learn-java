package cn.crabapples.system.sysDict.contoller;

import cn.crabapples.common.base.BaseController;
import cn.crabapples.common.base.ResponseDTO;
import cn.crabapples.system.sysDict.entity.SysDict;
import cn.crabapples.system.sysDict.entity.SysDictItem;
import cn.crabapples.system.sysDict.form.DictForm;
import cn.crabapples.system.sysDict.form.DictItemForm;
import cn.crabapples.system.sysDict.service.SystemDictService;
import com.mybatisflex.core.paginate.Page;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Api("系统接口[字典]")
@Slf4j
@RequestMapping("/api/system/dict")
public class SystemDictController extends BaseController {

    private final SystemDictService dictService;

    public SystemDictController(SystemDictService dictService) {
        this.dictService = dictService;
    }


    @GetMapping("/page")
    @Operation(summary = "系统字典", description = "系统字典接口")
    public ResponseDTO<Page<SysDict>> getDictPage(@RequestParam(required = false, defaultValue = "1") Integer pageIndex,
                                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                  DictForm form) {
        log.info("收到请求->获取系统字典:[{}]", form);
        Page<SysDict> list = dictService.getDictPage(pageIndex, pageSize, form);
        log.debug("返回结果->获取系统字典完成:[{}]", list);
        return new ResponseDTO<>(list);
    }

    @PostMapping("/save")
    @Operation(summary = "系统字典", description = "保存系统字典接口")
    public ResponseDTO<Boolean> saveDict(@RequestBody DictForm form) {
        log.info("收到请求->保存系统字典:[{}]", form);
        boolean status = dictService.saveDict(form);
        log.debug("返回结果->保存系统字典完成:[{}]", status);
        return new ResponseDTO<>(status);
    }

    @DeleteMapping("/remove/{id}")
    @Operation(summary = "系统字典", description = "删除系统字典接口")
    public ResponseDTO<Boolean> deleteById(@PathVariable String id) {
        log.info("收到请求->删除系统字典:[{}]", id);
        boolean status = dictService.deleteById(id);
        log.debug("返回结果->删除系统字典完成:[{}]", status);
        return new ResponseDTO<>(status);
    }

    @PostMapping("/item/save")
    @Operation(summary = "系统字典", description = "保存系统字典项接口")
    public ResponseDTO<Boolean> saveDictItem(@RequestBody DictItemForm form) {
        log.info("收到请求->保存系统字典项:[{}]", form);
        boolean status = dictService.saveDictItem(form);
        log.debug("返回结果->保存系统字典项完成:[{}]", status);
        return new ResponseDTO<>(status);
    }

    @GetMapping("/item/list/code/{code}")
    @Operation(summary = "系统字典", description = "获取系统字典项接口{code}")
    public ResponseDTO<List<SysDictItem>> getDictItemListByCode(@PathVariable String code) {
        log.info("收到请求->获取系统字典项,code:[{}]", code);
        List<SysDictItem> list = dictService.getDictItemListByCode(code);
        log.debug("返回结果->获取系统字典项完成:[{}]", list);
        return new ResponseDTO<>(list);
    }


    @GetMapping("/item/list/id/{id}")
    @Operation(summary = "系统字典", description = "获取系统字典项接口{id}")
    public ResponseDTO<List<SysDictItem>> getDictItemListById(@PathVariable String id) {
        log.info("收到请求->获取系统字典项,id:[{}]", id);
        List<SysDictItem> list = dictService.getDictItemListById(id);
        log.debug("返回结果->获取系统字典项完成:[{}]", list);
        return new ResponseDTO<>(list);
    }

    @DeleteMapping("/item/remove/{id}")
    @Operation(summary = "系统字典", description = "删除系统字典接口")
    public ResponseDTO<Boolean> deleteItemById(@PathVariable String id) {
        log.info("收到请求->删除系统字典项:[{}]", id);
        boolean status = dictService.deleteItemById(id);
        log.debug("返回结果->删除系统字典项完成:[{}]", status);
        return new ResponseDTO<>(status);
    }
}
