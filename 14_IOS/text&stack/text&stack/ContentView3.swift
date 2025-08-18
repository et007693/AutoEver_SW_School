//
//  ContentView3.swift
//  text&stack
//
//  Created by Admin on 8/18/25.
//

import SwiftUI

struct ContentView3: View {
    var body: some View {
        VStack(spacing: 0) {
            Text("Hello, World!")
                .background(.red)
            Color.blue
                .frame(width: 100, height: 100) // 명시적으로 크기 지정
        }
    }
}

#Preview {
    ContentView3()
}
