import React, {useEffect, useRef} from 'react';
import functionPlot from 'function-plot';

export default function SystemPlot({ f1, f2, range }) {
    const rootEl = useRef(null)

   useEffect(() => {
       functionPlot({
           target: rootEl.current,
           width: 500,
           height: 600,
           grid: true,
           data: [
               {
                   fn: f1
               },
               {
                   fn: f2
               }
           ]
       });
   })

    return (<div ref={rootEl} />)
}