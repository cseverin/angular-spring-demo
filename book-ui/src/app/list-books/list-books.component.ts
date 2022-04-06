import { Component, OnInit } from '@angular/core';
import { Book } from '../beans/Book';
import { LoadDataService } from '../service/load-data.service';

@Component({
  selector: 'app-list-books',
  templateUrl: './list-books.component.html',
  styleUrls: ['./list-books.component.scss']
})
export class ListBooksComponent implements OnInit {

  list?:Book[];

  constructor(private service: LoadDataService) { }

  ngOnInit(): void {
    this.service.listBooks().forEach((result=>{
      this.list = result;
    }));
  }


}
