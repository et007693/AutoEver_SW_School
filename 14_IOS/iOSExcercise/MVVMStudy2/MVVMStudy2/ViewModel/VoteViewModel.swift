//
//  VoteViewModel.swift
//  MVVMStudy2
//
//  Created by Admin on 8/29/25.
//

import Foundation

class VoteViewModel: ObservableObject {
    @Published var vote:Vote = Vote(id: UUID(), title: "원래 투표 제목")
}
