import { Component, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JikanService } from '../jikan.service';

@Component({
  selector: 'app-anime-details',
  templateUrl: './anime-details.component.html',
  styleUrl: './anime-details.component.css',
})
export class AnimeDetailsComponent {
  malId: any;
  anime: any;

  constructor(
    private route: ActivatedRoute,
    private jikanService: JikanService
  ) {}

  ngOnInit() {
    this.malId = String(this.route.snapshot.paramMap.get('id')); // Get MAL ID from URL route

    this.jikanService.getById(this.malId).subscribe((data) => {
      this.anime = data.data;
    });
  }
}
