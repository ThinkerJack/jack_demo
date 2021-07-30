import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TableComponent } from './ng_bootstrap/table.component';
import { DemoComponent } from './ng_zorro/demo/demo.component';

const routes: Routes = [
  { path: 'ng_bootstrap_demo', component: TableComponent },
  { path: 'ng_zorro_demo', component: DemoComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }