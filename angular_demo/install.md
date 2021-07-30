# 1 安装node

https://nodejs.org/en/

```
npm -v
```

7.2.0

# 2 安装 Angular CLI

```
npm install -g @angular/cli
```

angular版本

![](https://img-blog.csdnimg.cn/20210402103233253.png)

创建项目

运行 CLI 命令 `ng new` 并提供 `my-app` 名称作为参数，如下所示：

```
ng new my-app
```

启动项目

```
ng serve
```

浏览器访问 localhost:4200

# 3 ng-bootstrap

## 3.1 安装

简介：仅使用Bootstrap 4 CSS和为Angular生态系统设计的API完全构建的Angular窗口小部件。

cd到工程目录下

```bash
ng add @ng-bootstrap/ng-bootstrap
```

[手动安装文档](https://ng-bootstrap.github.io/#/getting-started)

## 3.2 选择组件

[组件列表地址](https://ng-bootstrap.github.io/#/components/accordion/examples)

- 表格組件 [Table](https://ng-bootstrap.github.io/#/components/table)

- 分页组件 [Pagination](https://ng-bootstrap.github.io/#/components/pagination)
- 日期组件 [Datepicker](https://ng-bootstrap.github.io/#/components/datepicker/overview)
- 弹窗 [Popover](https://ng-bootstrap.github.io/#/components/popover/examples)
- Tab页 [Nav](https://ng-bootstrap.github.io/#/components/nav/overview)
- 下拉列表 dropDown

## 3.3 项目页面展示

![](https://img-blog.csdnimg.cn/20210402153724368.png)

![](https://img-blog.csdnimg.cn/2021040215375197.png)

# 4 NG-ZORRO

## 4.1 安装

简介：`ng-zorro-antd` 是遵循 Ant Design 设计规范的 Angular UI 组件库，主要用于研发企业级中后台产品。全部代码开源并遵循 MIT 协议，任何企业、组织及个人均可免费使用。

cd到工程目录下

```
ng add ng-zorro-antd
```

由于引入了多个组件库，必须手动安装

### 4.1.1 引入样式#

#### 使用全部组件样式#

该配置将包含组件库的全部样式，如果只想使用某些组件请查看 [使用特定组件样式](https://ng.ant.design/docs/getting-started/zh#使用特定组件样式) 配置。

在 `angular.json` 中引入了

```json
{
  "styles": [
    "node_modules/ng-zorro-antd/ng-zorro-antd.min.css"
  ]
}
```

在 `style.css` 中引入预构建样式文件

```css
@import "~ng-zorro-antd/ng-zorro-antd.min.css";
```

或在 `style.less` 中引入 less 样式文件

```less
@import "~ng-zorro-antd/ng-zorro-antd.less";
```

#### 使用特定组件样式#

> 由于组件之间的样式也存在依赖关系，单独引入多个组件的 CSS 可能导致 CSS 的冗余。

使用特定组件样式时前需要先引入基本样式(所有组件的共用样式)。

在 `style.css` 中引入预构建样式文件

```css
@import "~ng-zorro-antd/style/index.min.css"; /* 引入基本样式 */
@import "~ng-zorro-antd/button/style/index.min.css"; /* 引入组件样式 */
```

或在 `style.less` 中引入 less 样式文件

```less
@import "~ng-zorro-antd/style/entry.less"; /* 引入基本样式 */
@import "~ng-zorro-antd/button/style/entry.less"; /* 引入组件样式 */
```

### 4.1.2 引入组件模块#

最后你需要将想要使用的组件模块引入到你的 `app.module.ts` 文件和[特性模块](https://angular.cn/guide/feature-modules)中。

以下面的 `NzButtonModule` 模块为例，先引入组件模块：

```ts
import { NgModule } from '@angular/core';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    NzButtonModule
  ]
})
export class AppModule { }
```

然后在模板中使用：

```html
<button nz-button nzType="primary">Primary</button>
```

全部组件

```typescript

import { NzAffixModule } from 'ng-zorro-antd/affix';
import { NzAlertModule } from 'ng-zorro-antd/alert';
import { NzAnchorModule } from 'ng-zorro-antd/anchor';
import { NzAutocompleteModule } from 'ng-zorro-antd/auto-complete';
import { NzAvatarModule } from 'ng-zorro-antd/avatar';
import { NzBackTopModule } from 'ng-zorro-antd/back-top';
import { NzBadgeModule } from 'ng-zorro-antd/badge';
import { NzBreadCrumbModule } from 'ng-zorro-antd/breadcrumb';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzCalendarModule } from 'ng-zorro-antd/calendar';
import { NzCardModule } from 'ng-zorro-antd/card';
import { NzCarouselModule } from 'ng-zorro-antd/carousel';
import { NzCascaderModule } from 'ng-zorro-antd/cascader';
import { NzCheckboxModule } from 'ng-zorro-antd/checkbox';
import { NzCollapseModule } from 'ng-zorro-antd/collapse';
import { NzCommentModule } from 'ng-zorro-antd/comment';
import { NzNoAnimationModule } from 'ng-zorro-antd/core/no-animation';
import { NzTransButtonModule } from 'ng-zorro-antd/core/trans-button';
import { NzWaveModule } from 'ng-zorro-antd/core/wave';
import { NzDatePickerModule } from 'ng-zorro-antd/date-picker';
import { NzDescriptionsModule } from 'ng-zorro-antd/descriptions';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NzDrawerModule } from 'ng-zorro-antd/drawer';
import { NzDropDownModule } from 'ng-zorro-antd/dropdown';
import { NzEmptyModule } from 'ng-zorro-antd/empty';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzGridModule } from 'ng-zorro-antd/grid';
import { NzI18nModule } from 'ng-zorro-antd/i18n';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzImageModule } from 'ng-zorro-antd/image';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzInputNumberModule } from 'ng-zorro-antd/input-number';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzListModule } from 'ng-zorro-antd/list';
import { NzMentionModule } from 'ng-zorro-antd/mention';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NzMessageModule } from 'ng-zorro-antd/message';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzNotificationModule } from 'ng-zorro-antd/notification';
import { NzPageHeaderModule } from 'ng-zorro-antd/page-header';
import { NzPaginationModule } from 'ng-zorro-antd/pagination';
import { NzPopconfirmModule } from 'ng-zorro-antd/popconfirm';
import { NzPopoverModule } from 'ng-zorro-antd/popover';
import { NzProgressModule } from 'ng-zorro-antd/progress';
import { NzRadioModule } from 'ng-zorro-antd/radio';
import { NzRateModule } from 'ng-zorro-antd/rate';
import { NzResultModule } from 'ng-zorro-antd/result';
import { NzSelectModule } from 'ng-zorro-antd/select';
import { NzSkeletonModule } from 'ng-zorro-antd/skeleton';
import { NzSliderModule } from 'ng-zorro-antd/slider';
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzStatisticModule } from 'ng-zorro-antd/statistic';
import { NzStepsModule } from 'ng-zorro-antd/steps';
import { NzSwitchModule } from 'ng-zorro-antd/switch';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzTabsModule } from 'ng-zorro-antd/tabs';
import { NzTagModule } from 'ng-zorro-antd/tag';
import { NzTimePickerModule } from 'ng-zorro-antd/time-picker';
import { NzTimelineModule } from 'ng-zorro-antd/timeline';
import { NzToolTipModule } from 'ng-zorro-antd/tooltip';
import { NzTransferModule } from 'ng-zorro-antd/transfer';
import { NzTreeModule } from 'ng-zorro-antd/tree';
import { NzTreeViewModule } from 'ng-zorro-antd/tree-view';
import { NzTreeSelectModule } from 'ng-zorro-antd/tree-select';
import { NzTypographyModule } from 'ng-zorro-antd/typography';
import { NzUploadModule } from 'ng-zorro-antd/upload';
import { NzResizableModule } from 'ng-zorro-antd/resizable';
import { NzPipesModule } from 'ng-zorro-antd/pipes';
```

imports

```typescript
 NzButtonModule,
    NzAffixModule,
    NzAlertModule,
    NzAnchorModule,
    NzAutocompleteModule,
    NzAvatarModule,
    NzBackTopModule,
    NzBadgeModule,
    NzButtonModule,
    NzBreadCrumbModule,
    NzCalendarModule,
    NzCardModule,
    NzCarouselModule,
    NzCascaderModule,
    NzCheckboxModule,
    NzCollapseModule,
    NzCommentModule,
    NzDatePickerModule,
    NzDescriptionsModule,
    NzDividerModule,
    NzDrawerModule,
    NzDropDownModule,
    NzEmptyModule,
    NzFormModule,
    NzGridModule,
    NzI18nModule,
    NzIconModule,
    NzImageModule,
    NzInputModule,
    NzInputNumberModule,
    NzLayoutModule,
    NzListModule,
    NzMentionModule,
    NzMenuModule,
    NzMessageModule,
    NzModalModule,
    NzNoAnimationModule,
    NzNotificationModule,
    NzPageHeaderModule,
    NzPaginationModule,
    NzPopconfirmModule,
    NzPopoverModule,
    NzProgressModule,
    NzRadioModule,
    NzRateModule,
    NzResultModule,
    NzSelectModule,
    NzSkeletonModule,
    NzSliderModule,
    NzSpinModule,
    NzStatisticModule,
    NzStepsModule,
    NzSwitchModule,
    NzTableModule,
    NzTabsModule,
    NzTagModule,
    NzTimePickerModule,
    NzTimelineModule,
    NzToolTipModule,
    NzTransButtonModule,
    NzTransferModule,
    NzTreeModule,
    NzTreeViewModule,
    NzTreeSelectModule,
    NzTypographyModule,
    NzUploadModule,
    NzWaveModule,
    NzResizableModule,
    NzPipesModule,
```

官方安装文档

https://ng.ant.design/docs/getting-started/zh

## 4.2 选择组件

[组件地址](https://ng.ant.design/components/overview/zh)

- 按钮 [button](https://ng.ant.design/components/button/zh)
- 布局 [layout](https://ng-zorro.gitee.io/components/layout/zh)
- 下拉列表 [dropdown](https://ng-zorro.gitee.io/components/dropdown/zh)
- 日期选择 [datetimepicker](https://ng-zorro.gitee.io/components/date-picker/zh)
- 联动选择器 [select](https://ng-zorro.gitee.io/components/select/zh) 
- 图片上传 [upload](https://ng-zorro.gitee.io/components/upload/zh)
- 骨架屏 [skeleton](https://ng-zorro.gitee.io/components/skeleton/zh) 
- 加载 [Spin](https://ng-zorro.gitee.io/components/spin/zh)

## 4.3 项目页面展示

![](https://img-blog.csdnimg.cn/20210402155635665.png)

## 5 github地址

https://github.com/jack0-0wu/angular_demo