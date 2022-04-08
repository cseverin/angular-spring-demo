import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Edit } from '../beans/Edit';
import { LoadDataService } from '../service/load-data.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.scss']
})
export class EditBookComponent implements OnInit {

  id?: number;
  edit?: Edit;
  isNew: boolean = true;

  constructor(private service: LoadDataService, private route: ActivatedRoute, private router: Router, private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      let id: string | null = params.get('id');
      if (id != null) {
        this.id = +id;
        this.isNew = this.id < 0;
        this.service.getBook(this.id).forEach(result => {
          this.edit = result;
        });
      }
    });
  }

  store() {
    console.log('store...');
    if (this.edit && this.edit.book) {
      this.service.store(this.edit.book).forEach((result) => {
        this.edit = result;
        if (this.edit && this.edit.book) {

          this.openSnackBar(this.edit.book.title + ' wurde erfolgreich gespeichert');

          if (this.isNew) {
            this.router.navigate(['book', this.edit.book.id]);
          }
        }

      }).catch((e) => {
        console.log('error: ' + e);
      });
    }
  }



  openSnackBar(message: string) {
    this._snackBar.open(message, '', {
      duration: 3000
    });
  }


  delete() {
    if (this.edit && this.edit.book && this.edit.book.id) {
      let title:string | undefined = this.edit.book.title;
      this.service.deleteBook(this.edit.book.id).forEach(() => {
        this.openSnackBar(title + " wurde erfolgreich gelöscht");
        this.router.navigate(['book/', 'list']);
      });
    }
  }


}
