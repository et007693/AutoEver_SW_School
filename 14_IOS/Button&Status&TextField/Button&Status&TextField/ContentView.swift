//
//  ContentView.swift
//  Button&Status&TextField
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView: View {
    @State private var message = "안녕하세요"
    var body: some View {
        VStack {
            Text(message)
                .padding(.bottom, 16)
            Button("글자 변경") { // 람다식과 비슷, 스위프트에서는 클로저라고 부름
                print("글자 변경을 요청합니다!")
                message = "반갑습니다"
            }
//            .buttonStyle(.bordered)
            .buttonStyle(.borderedProminent)
        }
        .padding()
    }
}

#Preview {
    ContentView()
}
