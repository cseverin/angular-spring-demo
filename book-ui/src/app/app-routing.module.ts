import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditBookComponent } from './edit-book/edit-book.component';
import { ListBooksComponent } from './list-books/list-books.component';

const routes: Routes = [
  { path: 'book/list', component: ListBooksComponent },
  { path: 'book/:id', component: EditBookComponent },
  { path: '',   redirectTo: '/book/list', pathMatch: 'full' }, // redirect to 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
