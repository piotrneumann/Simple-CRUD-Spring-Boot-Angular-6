import {NgModule} from '@angular/core';
import {PostEditComponent} from "./routing/post-edit/post-edit.component";
import {RouterModule, Routes} from "@angular/router";
import {PostListComponent} from "./routing/post-list/post-list.component";

const appRoutes: Routes = [
  {path: '', component: PostListComponent ,pathMatch: 'full'},
  {path: 'post-list', component: PostListComponent},
  {path: 'post-add', component: PostEditComponent},
  {path: 'post-edit/:id', component: PostEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
