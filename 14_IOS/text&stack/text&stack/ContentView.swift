//
//  ContentView.swift
//  text&stack
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack { // 세로로 자식 뷰를 배치한다.
            Text("텍스트1")
            Text("Placeholder")
                .font(.title)
            VStack {
                Text("Placeholder2")
                    .font(.system(size: 24))
            }
            VStack {
                Text("안녕하세요.")
                    .font(.body)
                    .bold()
                    .italic()
                    .foregroundStyle(.red)
            }
            Text("SwiftUI는\n엄청나게\n쉽습니다.")
                .lineSpacing(10)
                .lineLimit(2)
            Text("안녕하세요 여러분! 스위프트UI를 배워보겠습니다. 안녕하세요 여러분! 스위프트UI를 배워보겠습니다.")
                .lineLimit(1)
                .truncationMode(.tail) // 잘릴 때 "..." 표시(기본 : .tail)
            Text("패딩, 배경, 테두리")
                .padding()
                .background(Color.yellow)
                .cornerRadius(20)
//                .border(Color.blue, width: 3)
//                .clipShape(RoundedRectangle(cornerRadius: 20))
                .clipShape(Capsule())
                .overlay( // 왼쪽, 오른족, 위, 아레 둥글게
//                    RoundedRectangle(cornerRadius: 20)
//                        .stroke(Color.blue, lineWidth: 3)
                    Capsule()
                        .stroke(Color.blue, lineWidth: 3)
                )
            HStack {
                Text("간단한 텍스트")
                Text("간단한 텍스트")
            }
        }
        
        HStack {} // 가로로 자식 뷰를 배치한다.
        ZStack {} // 중첩으로 자식 뷰를 배치한다.

    }
}

#Preview {
    ContentView()
}
