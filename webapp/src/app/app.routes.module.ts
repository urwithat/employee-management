import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CardComponent } from '../components/card/card.component';
import { ListComponent } from '../components/list/list.component';
import { UploadComponent } from '../components/upload/upload.component';

const routes: Routes = [
  {path: '', component: CardComponent, pathMatch: 'full'},
  {path: 'find', redirectTo: 'search'},
  {path: 'card', component: CardComponent},
  {path: 'list', component: ListComponent},
  {path: 'search', component: ListComponent},
  {path: '**', component: CardComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule {}