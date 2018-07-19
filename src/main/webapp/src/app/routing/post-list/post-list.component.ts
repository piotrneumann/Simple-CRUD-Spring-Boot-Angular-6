import { Component, OnInit } from '@angular/core';
import {PostData} from "../../shared/interfaces/post-data";
import {PostService} from "../../shared/services/post.service";

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {

  postList: Array<PostData>;

  constructor(private postService: PostService) { }

  ngOnInit() {
    this.postService.getAll().subscribe(
      data => this.postList = data);
  }

}
