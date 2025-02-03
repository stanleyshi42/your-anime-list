import { Component } from '@angular/core';
import { JikanService } from '../jikan.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css',
})
export class SearchComponent {
  query!: string;
  result: any;

  constructor(private jikanService: JikanService) {}

  submit() {
    if (this.query.length > 0) {
      this.jikanService.getSearch(this.query).subscribe((data) => {
        this.result = data.data;
      });
    }
  }
}
