const calcFu = (x)=> (i)=> {return Math.abs(x - ((i+x) % (x*2)));};

function encodeRailFenceCipher(string, numberRails) {
  if (string.length === 0) return "";
  let fence = Array.from(Array(numberRails), () => new Array());
  let calcFu_i = calcFu(numberRails-1);
  
  [...string].forEach((c,i)=>{
    fence[calcFu_i(i)].push(c)
  })
  return fence.reduce((acc,c)=>{
    return acc + c.join('');
  },'');
}

function decodeRailFenceCipher(string, numberRails) {
  let fence_tot = Array(numberRails).fill(0);
  let fence = Array.from(Array(numberRails), () => new Array());
  let calcFu_i = calcFu(numberRails-1);
  let appo = [...string];
  appo.forEach((c,i)=>{
    fence_tot[calcFu_i(i)] += 1; 
  });
  fence_tot.forEach((tot,i)=>{
    fence[i] = appo.splice(0, tot);
  });
  let res = "";
  for (let i = 0; i < string.length; i++) {
    res += fence[calcFu_i(i)].shift();
  }
  return res;
}
