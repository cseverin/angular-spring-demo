import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Book } from '../beans/Book';
import { Edit } from '../beans/Edit';
import { LoadDataService } from '../service/load-data.service';

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.scss']
})
export class EditBookComponent implements OnInit {

  id?:number;
  edit?:Edit;

  constructor(private service: LoadDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      let id:string|null = params.get('id');
      if (id!=null){
        this.id = +id;
        this.service.getBook(this.id).forEach(result=>{
          this.edit = result;
        });
      }
    });
  }

  store(){
    console.log('store...');
  }

}
