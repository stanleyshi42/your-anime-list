import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { TopAnimeComponent } from './top-anime/top-anime.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'top', component: TopAnimeComponent },
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
